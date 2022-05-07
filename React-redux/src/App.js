import './App.css';
import Header from './components/Header/Header';
import 'bootstrap/dist/css/bootstrap.min.css';
import "bootstrap-icons/font/bootstrap-icons.css";
import RoutesComp from './components/Router/RoutesComp';
import React from 'react';
function App() {
  return (
    <div className="App">
        <Header />
        <RoutesComp />
    </div>
  );
}

export default App;