import React from 'react';
import styles from './Button.module.css';

const button = props => {
    return <button
        className={styles.button}
        disabled={props.disabled}
        onClick={props.clicked}>{props.children}</button>
}

export default button;