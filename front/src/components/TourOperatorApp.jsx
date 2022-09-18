import { Component } from "react";
import FooterComponent from "./pages/FooterComponent";
import HeaderComponent from "./pages/HeaderComponent";
import ListTourOperatorsComponent from "./pages/lists/ListTourOperatorsComponents.jsx";
import ListToursComponent from "./pages/lists/ListToursComponent.jsx";
import ListUsersComponent from "./pages/lists/ListUsersComponent.jsx";
import withNavigation from './helpFunctions/withNavigation.jsx'   
import withParams from './helpFunctions/withParams.jsx'
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom';
import ErrorComponent from "./helpFunctions/ErrorComponent";
import WelcomeComponent from "./pages/WelcomeComponent";
import CreateUserComponent from "./pages/CreateUserComponent";
import UpdateUserComponent from "./pages/UpdateUserComponent";

class TourOperatorApp extends Component{
    render(){
        const HeaderComponentWithNavigation = withNavigation(HeaderComponent);
        const ListUsersComponentWithNavigation = withNavigation(ListUsersComponent);
        const ListTourOperatorsComponentWithNavigation = withNavigation(ListTourOperatorsComponent);
        const ListToursComponentWithNavigation = withNavigation(ListToursComponent);
        const WelcomeComponentWithNavigation = withNavigation(WelcomeComponent);
        const CreateUserComponentWithNavigation = withNavigation(CreateUserComponent); 
        const UpdateUserComponentWithParamsAndNavigation = withParams(withNavigation(UpdateUserComponent)); 


        return(
            <div className="TourOperatorApp">
                <Router>
                    <HeaderComponentWithNavigation />
                    <Routes>
                        <Route path="/" element={<WelcomeComponentWithNavigation />} />
                        <Route path="/users" element={<ListUsersComponentWithNavigation />} />
                        <Route path="/touroperators" element={<ListTourOperatorsComponentWithNavigation />} />
                        <Route path="/tours" element={<ListToursComponentWithNavigation />} />
                        <Route path="/users/create" element={<CreateUserComponentWithNavigation />} />
                        <Route path="/users/:id" element={<UpdateUserComponentWithParamsAndNavigation />} />
                        <Route path="*" element={<ErrorComponent />} />
                    </Routes>
                    <FooterComponent />
                </Router>
            </div>
        )
    }
}

export default TourOperatorApp