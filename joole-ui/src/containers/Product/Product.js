import React, { Component } from 'react'
import styles from './Product.module.css';
import { connect } from 'react-redux';
import Headers from '../../components/Headers/Headers';
import ProductDetails from '../../components/ProductDisplay/ProductDetails/ProductDetails';
import ProductSummary from '../../components/ProductDisplay/ProductSummary/ProductSummary'
import ProductDocumentation from './../../components/ProductDisplay/ProductDocumentation/ProductDocumentation';
import Spinner from './../../components/UI/spinner/Spinner';
import Contact from '../../components/ProductDisplay/Contact/Contact';
import axios from '../../axios'
import withErrorHandler from './../../hoc/withErrorHandler';
import { Breadcrumb } from 'rsuite';
import { NavLink } from 'react-router-dom';

class Product extends Component {
    render() {
        let productSummary = <Spinner/>
        let productDetails = <Spinner/>
        let manufacturer = <Spinner/>

        if(!this.props.loadingType) 
            productSummary = <ProductSummary model={this.props.model} modelType={this.props.modelType}/>

        if(!this.props.loadingDetails) 
            productDetails = <ProductDetails modelDetails={this.props.modelDetails}/>

        if(!this.props.loadingBrand) 
            manufacturer = <Contact manufacturer={this.props.manufacturer}/>

        return (
            <div className={styles.product}>
                <div className= {styles.sticky}>
                    <Headers/>
                    <Breadcrumb className={styles.route}>
                    <NavLink to ={{ pathname: '/products'}}>Products</NavLink>
                    <NavLink to ={{ pathname: `/products/${this.props.model.id}`}}>{this.props.model.model}</NavLink>
                    </Breadcrumb>
                    <p className={styles.breadcrumb}>
                        <img className={styles.img} src={this.props.model.imgUrl} alt="modelImg"></img>
                        {this.props.model.manufacturer} / {this.props.model.series} / {this.props.model.model}</p>
                    <div className={styles.options}>
                        <a href="#productSummary">Product Summary</a>
                        <a href="#productDetails">Product Details</a>
                        <a href="#productDocumentation">Product Documentation</a>
                        <a href="#productContact">Product Contact</a>
                    </div>
                </div>


                <h3 id="productSummary" className={styles.h3}>Product Summary</h3>
                {productSummary}

                <h3 id="productDetails" className={styles.h3}>Product Details</h3>
                {productDetails}

                <h3 id="productDocumentation" className={styles.h3}>Product Documentation</h3>
                <ProductDocumentation/>

                <h3 id="productDocumentation" className={styles.h3}>Contact</h3>
                {manufacturer}
            </div>

        )
    }
}

const mapStateToProps = state => {
    return {
        model: state.model.model,
        modelType: state.model.modelType,
        modelDetails: state.model.modelDetails,
        manufacturer: state.model.manufacturer,
        loadingType: state.model.loadingType,
        loadingDetails: state.model.loadingDetails,
        loadingBrand: state.model.loadingBrand
    }
}
 
export default connect(mapStateToProps, null)(withErrorHandler(Product, axios));