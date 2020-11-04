import axios from 'axios';

const instance = axios.create({
    baseURL: 'http://localhost:8080/'
});

// instance.defaults.headers.common['Authorization'] = `eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyMSIsImV4cCI6MTYwMzkzOTUwMSwiaWF0IjoxNjAzOTAzNTAxfQ.SH0j46_OfqVKmyFRKLdGoW_VRVORs_nlE8jCObhCYMM`;

instance.interceptors.request.use(config => {
    const token = localStorage.getItem('token');
    config.headers.Authorization =  token ? `Bearer ${token}` : '';
    return config;
});

export default instance;