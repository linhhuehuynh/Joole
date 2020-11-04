import React, { Component } from 'react';
import Search from '../Search/Search';
import styles from './Headers.module.css';
import logo from '../../logo.png';
import { Link, NavLink } from 'react-router-dom';



export default class Headers extends Component {

    render() {
        return (
            <div className={styles.headers}>
                <Link to="/">
                <img onClick={this.redirect} src={logo} className={styles.logo} alt="logo" />
                </Link>
                <div className={styles.search}><Search/></div>
                <NavLink to ={{ pathname: '/logout'}}>
                   <p className={styles.p}>LOG OUT</p>
                </NavLink>
            </div>
        )
    }
}
