
import React from 'react'
import styles from './ProductSummary.module.css';

const ProductSummary = (props) => {
    const {model} = props;

    return (
        <div className={styles.productSummary}>
        <div className={styles.tableSpilt}>
            <table className={styles.description}>
                <thead>
                    <tr className={styles.title}><td colSpan="2">DESCRIPTION</td></tr>
                </thead>

                <tbody>
                    <tr><td className={styles.sub}>Manufacturer</td>
                        <td>{model.manufacturer}</td></tr>

                    <tr><td className={styles.sub}>Series</td>
                        <td>{model.series}</td></tr>

                    <tr><td className={styles.sub}>Model</td>
                        <td>{model.model}</td></tr>
                </tbody>

                <thead>
                    <tr className={styles.title}><td colSpan="2">TYPE</td></tr>
                </thead>

                <tbody>
                    {props.modelType.map(type =>{
                        return  <tr key={type.modelTypeId}>
                                <td className={styles.sub}>{type.name}</td>
                                <td>{type.value}</td></tr>
                    })}
                </tbody>  
            </table>

            <table className={styles.spec}>
                <thead>
                    <tr className={styles.title}><td colSpan="5">TECHNICAL SPECIFICATIONS</td></tr>
                </thead>

                <tbody>
                    {model.modelSpecs.map(spec =>{
                        
                        if(spec.name === 'Power (W)' || spec.name === 'Operating voltage (VAC)' || spec.name === 'Fan speed (RPM)' || spec.name === 'Height (in)') {
                            return <tr key={spec.modelSpecsId}>
                            <td className={styles.sub}>{spec.name}</td>
                            <td className={styles.minmax}>Min</td>
                            <td>{spec.defaultOrMin}</td>
                            <td className={styles.minmax}>Max</td>
                            <td>{spec.max}</td></tr>
                        }

                        return <tr key={spec.modelSpecsId}>
                            <td className={styles.sub}>{spec.name}</td>
                            <td colSpan="4">{spec.defaultOrMin}</td>
                        </tr>
                    })}
                </tbody>             
            </table>
        </div>                
        </div>
      );
}
 
export default ProductSummary;