import React from 'react';
import styles from './ModelCompare.module.css';

const ModelCompare = (props) => {
    return (
        <table>
            <tbody>
                <tr><td colSpan="4">{props.brand}</td></tr>
                <tr><td colSpan="4">{props.series}</td></tr>
                <tr><td colSpan="4">{props.model}</td></tr>

                {props.specs.map(spec => {
                    if(spec.name === 'Power (W)' || spec.name === 'Operating voltage (VAC)' || spec.name === 'Fan speed (RPM)' || spec.name === 'Height (in)') {
                        return <tr key={spec.modelSpecsId}>
                        <td className={styles.minmax}>Min</td>
                        <td>{spec.defaultOrMin}</td>
                        <td className={styles.minmax}>Max</td>
                        <td>{spec.max}</td></tr>
                    }

                    return <tr key={spec.modelSpecsId}>
                        <td colSpan="4">{spec.defaultOrMin}</td>
                    </tr>
                })}

            <tr>
                <td colSpan="4"><img className={styles.img} src={props.img} alt="modelImg"></img></td>
            </tr>
            </tbody>
            
        </table>
      );
}
 
export default ModelCompare;