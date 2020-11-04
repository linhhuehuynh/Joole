import * as actionTypes from '../actions/types';
import { updatedObject } from './../utility';

const initialState = {
    categoryList: [],
    productLineList: [],
    lineSpecsList: [],
    modelList: [],
    error: false,
};

const setCategoryList = (state, action) => {
    return updatedObject( state, {
        categoryList: action.categoryList
    })
}

const setProductLineList = (state, action) => {
    return updatedObject ( state, {
        productLineList: action.productLineList
    })
}

const setLineSpecsList = (state, action) => {
    return updatedObject ( state, {
        lineSpecsList: action.lineSpecsList
    })
}

const setModelList = (state, action) => {
    return updatedObject ( state, {
        modelList: action.modelList
    })
}

const reducer = (state = initialState, action) => {
    switch (action.type) {
        case actionTypes.SET_CATEGORY_LIST: return setCategoryList(state, action);
        case actionTypes.SET_PRODUCTLINE_LIST: return setProductLineList(state, action);
        case actionTypes.SET_LINESPECS_LIST: return setLineSpecsList(state, action);
        case actionTypes.SET_MODEL_LIST: return setModelList(state, action);

        default: return state;
    }
};

export default reducer;