import axios from '../../axios'
import * as actionTypes from './types';

export const fetchStart = () => {
    return {type: actionTypes.FETCH_START};
};

export const setModel = model => {
    return {
        type: actionTypes.SET_MODEL,
        model
    }
}

export const setModelType = modelType => {
    return {
        type: actionTypes.SET_MODEL_TYPE,
        modelType
    }
}

export const setModelDetails = modelDetails => {
    return {
        type: actionTypes.SET_MODEL_DETAILS,
        modelDetails
    }
}

export const setManufacturer = manufacturer => {
    return {
        type: actionTypes.SET_MANUFACTURER,
        manufacturer
    }
}

export const fetchModelType = modelId => {
    return dispatch => {
        dispatch(fetchStart());

        axios.get(`/modeltype/${modelId}`)
            .then(response => dispatch(setModelType(response.data)))
            .catch(error => console.log(error))
    }
}

export const fetchModelDetails = modelId => {
    return dispatch => {
        dispatch(fetchStart());

        axios.get(`/modeldetails/${modelId}`)
            .then(response => dispatch(setModelDetails(response.data)))
            .catch(error => console.log(error))
    }
}

export const fetchManufacturer = manufacturerId => {
    return dispatch => {
        dispatch(fetchStart());

        axios.get(`/manufacturer/${manufacturerId}`)
            .then(response => dispatch(setManufacturer(response.data)))
            .catch(error => console.log(error))
    }
}

export const fetchModel = model => {
    return dispatch => {
        dispatch(setModel(model));
    }
}