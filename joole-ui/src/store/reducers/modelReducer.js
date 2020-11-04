import { updatedObject } from './../utility';
import * as actionTypes from '../actions/types';

const initialState = {
    modelType: null,
    modelDetails: null,
    model: null,
    manufacturer: null,
    error: false,
    loadingType: false,
    loadingDetails: false,
    loadingBrand: false
};

const fetchStart = (state, action) => {
    return updatedObject(state, {error: null, loadingType: true, loadingDetails:true, loadingBrand: true});
};

const setModel = (state, action) => {
    return updatedObject ( state, {
        model: action.model
    })
}

const setModelType = (state, action) => {
    return updatedObject ( state, {
        modelType: action.modelType,
        loadingType: false
    })
}

const setModelDetails = (state, action) => {
    return updatedObject ( state, {
        modelDetails: action.modelDetails,
        loadingDetails: false
    })
}

const setManufacturer = (state, action) => {
    return updatedObject( state , {
        manufacturer: action.manufacturer,
        loadingBrand: false
    })
}

const reducer = (state = initialState, action) => {
    switch (action.type) {
        case actionTypes.FETCH_START: return fetchStart(state, action);
        case actionTypes.SET_MODEL_TYPE: return setModelType(state, action);
        case actionTypes.SET_MODEL_DETAILS: return setModelDetails(state, action);
        case actionTypes.SET_MODEL: return setModel(state, action);
        case actionTypes.SET_MANUFACTURER: return setManufacturer(state, action);
        default: return state;
    }
};

export default reducer;