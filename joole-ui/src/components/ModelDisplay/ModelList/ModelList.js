import React, { Component } from 'react'
import Model from '../Model/Model';
import { connect } from 'react-redux';
import { withRouter } from 'react-router-dom';

import * as actions from '../../../store/actions/index';
import Button from './../../UI/button/Button';


class ModelList extends Component {

    state = {
        compareArr: []
    }

    selectedModel = model => {
        this.props.fetchModelType(model.id);
        this.props.fetchModelDetails(model.id);
        this.props.fetchModel(model);
        this.props.fetchManufacturer(model.manufacturerId);
        this.props.history.push( '/products/'+ model.id);
    }

    check = model =>{
        let compareArr = this.state.compareArr;
        compareArr.push(model);
        this.setState({
            compareArr
        })
    }

    compare = () => {
        console.log('reroute')
        this.props.history.push('/compare', this.state.compareArr);
    }

    render() {
        return (
            <div>
                {this.props.models.map((model, index) => {
                    return <Model
                                key={model.id}
                                img={model.imgUrl}
                                brand={model.manufacturer}
                                series={model.series}
                                model={model.model}
                                specs={model.modelSpecs}
                                onClick={() => this.selectedModel(model)}
                                check={()=> this.check(model)}
                            />
                })}
                <button onClick={this.compare}>Compare</button>
            </div>
        )
    }
}

const mapStateToProps = state => {
    return {
        models: state.search.modelList
    }
}

const mapDispatchToProps = dispatch => {
    return {
        fetchModelType: modelId => dispatch(actions.fetchModelType(modelId)),
        fetchModelDetails: modelId => dispatch(actions.fetchModelDetails(modelId)),
        fetchModel: model => dispatch(actions.fetchModel(model)),
        fetchManufacturer: manufacturerId => dispatch(actions.fetchManufacturer(manufacturerId))
    }
}


export default connect(mapStateToProps, mapDispatchToProps) (withRouter(ModelList))
