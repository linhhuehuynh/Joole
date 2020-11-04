import React from 'react';
import styles from './ProductDetails.module.css';

const ProductDetails = props => {
    return (
            <div className={styles.productDetails}>
                <table>
                    <thead>
                        <tr className={styles.title}><td>SERIES INFORMATION</td></tr>
                    </thead>

                    <tbody>
                        {props.modelDetails.map((detail,index) => {
                            if (index%2===0) return <tr className={styles.detailColor}><td>{detail.detail}</td></tr>;
                            return <tr><td>{detail.detail}</td></tr>
                        })}
                    </tbody>
                </table>
            </div>
      );
}

export default ProductDetails;
