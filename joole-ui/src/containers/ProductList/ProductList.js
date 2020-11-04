import React, { Component } from 'react';
import Headers from '../../components/Headers/Headers';
import RangeList from '../../components/RangeFilter/RangeList';

import ModelList from '../../components/ModelDisplay/ModelList/ModelList';
import styles from './ProductList.module.css';
import axios from '../../axios';
import withErrorHandler from './../../hoc/withErrorHandler';

class ProductList extends Component {
  
    render() {
        return (
            <div className={styles.productList}>
                <Headers/>
                <div className={styles.container}>
                    <RangeList/>
                    <ModelList/>
                </div>
            </div>
        )
    }
}

export default (withErrorHandler(ProductList, axios))