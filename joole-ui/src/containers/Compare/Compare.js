import React, { Component } from 'react';
import styles from './Compare.module.css'
import Headers from './../../components/Headers/Headers';
import ModelCompare from '../../components/ModelCompare/ModelCompare';
import { Breadcrumb } from 'rsuite';
import { NavLink } from 'react-router-dom';

export default class Compare extends Component {

    state = {
        compareList: this.props.location.state
    }

    render() {
        this.state.compareList[0].modelSpecs.map(spec => console.log(spec.name))
        return (
            <div className={styles.compare}>
                <Headers/>
                    <Breadcrumb className={styles.route}>
                    <NavLink to ={{ pathname: '/products'}}>Products</NavLink>
                    </Breadcrumb>
                <div className={styles.container}>

                    <table>
                            <tr><td>Manufacturer</td></tr>
                            <tr><td>Series</td></tr>
                            <tr><td>Model</td></tr>

                            {this.state.compareList[0].modelSpecs.map(spec =>{
                                return <tr><td>{spec.name}</td></tr>
                            })}
                    </table>
                    {this.state.compareList.map(model =>{
                        return <ModelCompare
                                key={model.id}
                                img={model.imgUrl}
                                brand={model.manufacturer}
                                series={model.series}
                                model={model.model}
                                specs={model.modelSpecs}
                                />
                    })
                    }
                </div>
            </div>
        )
    }
}
