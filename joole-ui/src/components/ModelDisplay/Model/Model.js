import React  from 'react';
import styles from './Model.module.css';
import Button from './../../UI/button/Button';
import {Breadcrumb} from 'rsuite';
import { NavLink } from 'react-router-dom';

const model = (props) => {
    let cfm = null;
    let maxPower = null;
    let dba = null;
    let diameter = null;

    for (let spec of props.specs) {
        if (spec.name === 'Airflow (CFM)') {
            cfm = spec.defaultOrMin;
            continue;}
        if (spec.name === 'Power (W)') {
            maxPower = spec.max;
            continue;}
        if (spec.name === 'Sound at max speed (dBA)') {
            dba = spec.defaultOrMin;
            continue;}
        if (spec.name === 'Fan sweep diameter (in)') {
            diameter = spec.defaultOrMin;
            break;
        } 
    }
        
    return (
        <div className={styles.model}>
            <div onClick={props.onClick}>
            <img className={styles.img} src={props.img} alt="modelImg"></img>
            <div className={styles.title}>
                <p> {props.brand} <br></br>
                    {props.series}<br></br>
                    {props.model}</p>
            </div>

            <div className={styles.specs}>
                <p> {cfm} CFM <br></br>
                    {maxPower} W at max speed <br></br>
                    {dba} dBA at max speed <br></br>
                    {diameter} fan sweep diameter</p>
            </div>

            <div className={styles.history}>
                <p> Past specifications:<br></br>
                    10 firm/ 1492 global</p>
            </div>
            </div>

            <div className={styles.option}>
                <input type="checkbox" onClick={props.check}/>
                <label> Compare</label>
            </div>
                <Button>Add to</Button>

        </div>
    );
}
 
export default model;