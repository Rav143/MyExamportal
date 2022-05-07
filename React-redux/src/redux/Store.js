// import { createStore } from 'redux';
import { reducer } from './reducer';
import { legacy_createStore as createStore} from 'redux'

export const Store =  createStore(reducer,{})
