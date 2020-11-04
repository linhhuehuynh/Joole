import React, { Component } from 'react';
import Auth from '../../components/Auth/Auth';
import styles from './Home.module.css';
import logo from '../../logo.png'
import Search from '../../components/Search/Search';
import { connect } from 'react-redux';

class Home extends Component {
    render() {
        
        let component = <Search/>;
        console.log(this.props.isAuthenticated)
        if(!this.props.isAuthenticated) component =<Auth/>

        return (
            <div className={styles.home}>
                <img src={logo} className={styles.logo} alt="logo" />
                <h2 className={styles.h3}>Building Product Selection Platform</h2>
                {component}
            </div>
        )
    }
};

const mapStateToProps = state => {
    return {
        error: state.auth.error,
        isAuthenticated: state.auth.token !== null
    };
};

export default connect(mapStateToProps, null)(Home);


