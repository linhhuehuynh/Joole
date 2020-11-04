import axios from '../../axios';
import * as actionTypes from './types';

export const authStart = () => {
    return {type: actionTypes.AUTH_START};
};

export const authSuccess = (token, userId) => {
    return {
        type: actionTypes.AUTH_SUCCESS,
        token,
        userId
    };
};

export const registerSuccess = () => {
    return {
        type: actionTypes.REGISTER_SUCCESS
    }
}

export const authFail = error => {
    return {
        type: actionTypes.AUTH_FAIL,
        error
    };
};

export const logout = () => {
    localStorage.removeItem('token');
    localStorage.removeItem('expirationDate');
    localStorage.removeItem('userId');
    return {
        type: actionTypes.AUTH_LOGOUT
    };
};


export const checkAuthTimeout = (expirationTime) => {
    return dispatch => {
        setTimeout(() => {
            dispatch(logout());
        }, Date.parse(expirationTime) * 1000);
    };
};


export const auth = (username, password, isSignup) => {
    return dispatch => {
        dispatch(authStart());
        const authData = {
            username,
            password
        };

        if (isSignup) {
            axios.post('/signup', authData)
                .then(response => {
                    dispatch(registerSuccess());
                })
                .catch(error => {
                    dispatch(authFail(error.response.data))
                })

        }

        if (!isSignup) {
            axios.post('/login', authData)
            .then(response => {
                const expirationDate = new Date(new Date().getTime() + Date.parse(response.data.expiresIn) * 1000);
                localStorage.setItem('token', response.data.jwt);
                localStorage.setItem('expirationDate', expirationDate);
                localStorage.setItem('userId', response.data.id);
                console.log(localStorage)
                dispatch(authSuccess(response.data.jwt, response.data.userId));
                // dispatch(checkAuthTimeout(response.data.expiresIn));
            })
            .catch ( error => {
                dispatch(authFail(error.response.data));
            })
        }
    }
}

export const setAuthRedirectPath = path => {
    return {
        type: actionTypes.SET_AUTH_REDIRECT_PATH,
        path
    }
}

export const authCheckState = () => {
    return dispatch => {
        const token = localStorage.getItem('token');
        if (!token) {
            dispatch(logout());
        } else {
            const expirationDate = new Date(localStorage.getItem('expirationDate'));
            if (expirationDate <= new Date()) {
                dispatch(logout())
            } else {
                const userId = localStorage.getItem('userId');
                console.log(`auto auth ${userId}`)

                dispatch(authSuccess(token, userId));
                // dispatch(checkAuthTimeout((expirationDate.getTime() - new Date().getTime()) / 1000));
            }
        }
    }

}