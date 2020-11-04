import axios from '../../axios'
import * as actionTypes from './types';


export const setCategoryList = categoryList => {
    return {
        type: actionTypes.SET_CATEGORY_LIST,
        categoryList
    }
}

export const setProductLineList = productLineList => {
    return {
        type: actionTypes.SET_PRODUCTLINE_LIST,
        productLineList
    }
}

export const setLineSpecsList = lineSpecsList => {
    return {
        type: actionTypes.SET_LINESPECS_LIST,
        lineSpecsList
    }
}

export const setModelList = modelList => {
    return {
        type: actionTypes.SET_MODEL_LIST,
        modelList
    }
}

export const fetchProductLineList = categoryId => {
    return dispatch => {
        axios.get(`/productline/${categoryId}`)
            .then(response => {
                dispatch(setProductLineList(response.data))})
            .catch(error => {
                console.log(`Error ${error}`)
            })
    }
}

export const fetchCategoryList = () => {
    return dispatch => {
        axios.get('/category')
            .then(response => {
                dispatch(setCategoryList(response.data))})
            .catch(error => {
                console.log(`Error ${error}`)
            })
    }
}

export const fetchLineSpecsList = productLineName => {
    return dispatch => {
        axios.get(`/linespecs/${productLineName}`)
            .then(response => {
                dispatch(setLineSpecsList(response.data))})
            .catch(error => {
                console.log(error)
            })
    }
}

export const fetchModelList = productLineName => {
    return dispatch => {
        axios.get(`/model/${productLineName}`)
            .then(response => {
                dispatch(setModelList(response.data))})
            .catch(error => {
                console.log(error.response)
                    // dispatch(authFail(error.response.data))
                })
    }
}