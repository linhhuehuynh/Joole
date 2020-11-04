import React, { Component } from 'react';
import Input from '../UI/input/Input';
import Button from '../UI/button/Button';
import Spinner from '../UI/spinner/Spinner';
import styles from './Auth.module.css'
import {connect} from 'react-redux';
import * as actions from '../../store/actions/index';
import { Redirect } from 'react-router-dom';
// import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
// import { faUser } from '@fortawesome/free-solid-svg-icons'

class Auth extends Component {

    state = {
        controls: {
            username: {
                elementType: 'input',
                elementConfig: {
                    type: 'text',
                    placeholder: 'Username or Email'
                },
                value: '',
                validation: {
                    required: true,
                    minlength: 5
                },
                valid: false,
                touched: false
            },
            password: {
                elementType: 'input',
                elementConfig: {
                    type: 'password',
                    placeholder: 'Password'
                },
                value: '',
                validation: {
                    required: true,
                    minLength: 6
                },
                valid: false,
                touched: false
            }
        },
        isSignup: true
    }

    componentDidMount() {
        if (this.props.authRedirectPath !== '/') {
            this.props.onSetAuthRedirectPath();
        }
    }

    checkValidity (value, validation) {
        let isValid = true;

        if (!validation) return true;
        if (validation.required) isValid = value.trim() !== '' && isValid;
        if (validation.minLength) isValid = value.length >= validation.minLength && isValid;

        return isValid;
    }

    inputChangedHandler = (e, element) => {
        const controls = {
            ...this.state.controls,
            [element]: {
                ...this.state.controls[element],
                value: e.target.value,
                valid: this.checkValidity(e.target.value, this.state.controls[element].validation),
                touched: true
            }
        };
        this.setState({controls})
    }

    submitHandler = e => {
        e.preventDefault();
        this.props.onAuth(this.state.controls.username.value, this.state.controls.password.value, this.state.isSignup)
    }

    switchAuthModeHandler = () => {
        this.setState(prevState => {
            return {isSignup: !prevState.isSignup}
        });
    }

    render() {
        const formElementsArray = [];
        for (let key in this.state.controls) {
            formElementsArray.push({
                id: key,
                config: this.state.controls[key]
            })
        }

        let form = formElementsArray.map(element => {
            return <Input 
                key={element.id}
                elementType={element.config.elementType}
                elementConfig={element.config.elementConfig}
                value={element.config.value}
                invalid={!element.config.valid}
                shouldValidate={element.config.validation}
                touched={element.config.touched}
                changed={e => this.inputChangedHandler(e, element.id)}/>
        });

        if (this.props.loading) form = <Spinner/>

        let errorMessage = null;
        if (this.props.error) {
            errorMessage = (
            <p className={styles.error}>{this.props.error}</p>);
        }

        let authRedirect = null;
        if (this.props.isAuthenticated) {
            authRedirect = <Redirect to={this.props.authRedirectPath}/>
        }

        return (
            <div className={styles.auth}>
                {authRedirect}
                {errorMessage}
                <form onSubmit={this.submitHandler}>
                    {form}
                    <Button clicked={this.switchAuthModeHandler}>{this.state.isSignup? 'Log In' : 'Sign Up'}</Button>     
                </form>
                <div className={styles.inlineButton}>
                    <p className={styles.p}>{!this.state.isSignup? 'Have an account?': 'New to Joole?'}</p>
                    <Button clicked={this.switchAuthModeHandler}>{!this.state.isSignup? 'Log In' : 'Sign Up'}</Button>
                </div>

            </div>
        )
    }
};

const mapStateToProps = state => {
    return {
        loading: state.auth.loading,
        error: state.auth.error,
        isAuthenticated: state.auth.token !== null,
        authRedirectPath: state.auth.authRedirectPath
    };
};

const mapDispatchToProps = dispatch => {
    return {
        onAuth: (username, password, isSignup) => dispatch(actions.auth(username, password, isSignup)),
        onSetAuthRedirectPath: () => dispatch(actions.setAuthRedirectPath('/'))
    };
};



export default connect(mapStateToProps, mapDispatchToProps)(Auth);