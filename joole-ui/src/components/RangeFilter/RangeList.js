
import React, { Component } from 'react';
import Range from './Range';
import styles from './RangeList.module.css';
import { connect } from 'react-redux';

class RangeList extends Component {

    render() {
        return (
            <div className={styles.rangelist}>
                <div className={styles.searchRange}>
                    <p className={styles.sp}>Search: </p>
                    <button className={styles.button}>Save</button>
                    <button className={styles.button}>Clear</button>
                </div>

                <div className="buttonPro">
                    <button className={styles.buttonProW}>Product</button>
                    <button className={styles.buttonProW}>Project</button>
                </div>

                <p className={styles.p}>Product Type</p>

                <p  className={styles.p}
                    onClick={this.show}>Technical Specifications</p>
                    {this.props.lineSpecs.map((specs, index) => {
                        return <div key={specs.linesSpecsId}>
                                    <label><b>{specs.specsProperty.specsProperty}</b></label>
                                    <Range  min={specs.min}
                                            max={specs.max}/>
                                </div>
                    })}
               
                <p className={styles.p}>Brand</p>

                <p className={styles.p}
                    onClick={this.show}>Past Selections</p>
                   
                    <label><b>Firm</b></label>
                    <Range min={0} max={10}/>

                    <label><b>Global</b></label>
                    <Range min={0} max={1492}/>

                <p className={styles.p}>Certifications</p>
            </div>
        )
    }
}

const mapStateToProps = state => {
    return {
        lineSpecs: state.search.lineSpecsList
    }
}

export default connect(mapStateToProps, null) (RangeList)