import { combineReducers } from "redux";
import axios from 'axios';

// import user from './user'
// import notice from './notice'
import userSlice from "./userSlice";
import noticeSlice from "./noticeSlice"
import itemSlice from "./itemSlice"

//axios.defaults.baseURL = "http://localhost:8081/api/"
axios.defaults.baseURL = "https://i8a405.p.ssafy.io/api"


export default combineReducers({
    userSlice,
    noticeSlice,
    itemSlice

})
