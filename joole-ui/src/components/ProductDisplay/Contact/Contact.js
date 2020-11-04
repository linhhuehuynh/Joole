import React from 'react';
import styles from './Contact.module.css';

const Contact = (props) => {

    return (
        <div className={styles.contact}>
        <div className={styles.tableSpilt}>
            <table className={styles.resp}>
                <thead>
                    <tr className={styles.title}><td colSpan="2">SALES REPRESENTATIVE</td></tr>
                </thead>

                <tbody>
                    <tr><td className={styles.sub}>Name</td>
                        <td>{props.manufacturer.salesName}</td></tr>

                    <tr><td className={styles.sub}>Phone</td>
                        <td>{props.manufacturer.salesPhone}</td></tr>

                    <tr><td className={styles.sub}>Email</td>
                        <td>{props.manufacturer.salesEmail}</td></tr>

                    <tr><td className={styles.sub}>Web</td>
                        <td>{props.manufacturer.salesWeb}</td></tr>
                </tbody>
            </table>

            <table className={styles.brand}>
                <thead>
                    <tr className={styles.title}><td colSpan="2">MANUFACTURER</td></tr>
                </thead>

                <tbody>
                    <tr><td className={styles.sub}>Department</td>
                        <td>{props.manufacturer.dept}</td></tr>

                    <tr><td className={styles.sub}>Phone</td>
                        <td>{props.manufacturer.phone}</td></tr>

                    <tr><td className={styles.sub}>Email</td>
                        <td>{props.manufacturer.email}</td></tr>

                    <tr><td className={styles.sub}>Web</td>
                        <td>{props.manufacturer.web}</td></tr>
                </tbody>             
            </table>
        </div>                
        </div>
      );
}

export default Contact;

