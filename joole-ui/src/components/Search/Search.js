import React, { Component } from 'react';
import styles from './Search.module.css';
import {connect} from 'react-redux';
import * as actions from '../../store/actions/index';
import { withRouter } from 'react-router-dom';


class Search extends Component {

    componentDidMount() {
        this.props.fetchCategoryList();
    }

    handleCategory = e => {
        this.props.fetchProductLineList(e.target.value);

        this.setState(
            { [e.target.name]: e.target.value });
    }

    handleEnter = e => {
        if (e.key === 'Enter') {
            this.props.fetchLineSpecsList(e.target.value);
            this.props.fetchModelList(e.target.value)
            this.props.history.push('/products')
            }
    }

    render() {
        return (
            <div className={styles.search}>
                <select className={styles.select}
                        onChange={this.handleCategory}>
                    <option>Choose a Category</option>

                    {this.props.category.map((category, index) => {
                        return <option 
                                key={category.categoryId}
                                value={category.categoryId}
                                >{category.categoryName}</option>
                    })}
                </select>

                <input  className={styles.input}
                        list="lines" 
                        onKeyPress={this.handleEnter}
                        />

                <datalist id="lines" >
                        {this.props.productLine.map((line, index) => {
                                return <option 
                                        key={line.productLineId}
                                        value={line.productLine}
                                        >{line.productLine}</option>
                            })
                        }
                </datalist>
                
            </div>
        )
    }
}

const mapStateToProps = state => {
    return {
        category: state.search.categoryList,
        productLine: state.search.productLineList,
        lineSpecs: state.search.lineSpecsList
    }
}

const mapDispatchToProps = dispatch => {
    return {
        fetchCategoryList: () => dispatch(actions.fetchCategoryList()),
        fetchProductLineList: categoryId => dispatch(actions.fetchProductLineList(categoryId)),
        fetchLineSpecsList: productLineName => dispatch(actions.fetchLineSpecsList(productLineName)),
        fetchModelList: productLineName => dispatch(actions.fetchModelList(productLineName))
    }
}

export default connect(mapStateToProps, mapDispatchToProps) (withRouter(Search))