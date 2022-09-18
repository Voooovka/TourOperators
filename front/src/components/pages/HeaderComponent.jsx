import React, { Component } from 'react'
import {Link} from 'react-router-dom'

class HeaderComponent extends Component {
    render(){

        return(
            <header>
                <nav className="navbar navbar-expand-md navbar-dark bg-dark" style={{padding:'20px'}}>
                    <div><a href="https://st2.depositphotos.com/4684319/7048/i/450/depositphotos_70486253-stock-photo-happy-cat-blue-background.jpg" className="navbar-brand">javovka</a></div>
                    <ul className="navbar-nav">
                        <li><Link className="nav-link" to="/users">Users</Link></li>
                        <li><Link className="nav-link" to="/tours">Tours</Link></li>
                        <li><Link className="nav-link" to="/touroperators">Tour Operators</Link></li>
                    </ul>
                    <ul className="navbar-nav navbar-collapse justify-content-end">
                        <li><Link className="nav-link" to="/">Welcome</Link></li>
                    </ul>
                </nav>
            </header>
        )
    }
}

export default HeaderComponent