import './App.css';
import TourOperatorApp from './components/TourOperatorApp'
import React, { Component } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';


class App extends Component{
  render() {
    return (
      <div className="App">
        <TourOperatorApp />
      </div>
    );
  }
}

export default App;
