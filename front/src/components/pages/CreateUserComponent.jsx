import { Component } from "react";
import { Formik, Form, Field, ErrorMessage } from 'formik'
import UsersDataService from "../../api/UsersDataService";
import moment from 'moment'



class CreateUserComponent extends Component{

    constructor(props) {
        super(props)

        this.state = {
            username: '',
            lastname: '',
            birthdate: '',
            role: '',
            password: ''
        }
    }

    onSubmit = (values) => {

        let userRole = {
            id: 1,
            name: "USER"
        }

        let adminRole = {
            id: 2,
            name: "ADMIN"
        }

        let user = {
            username: values.username,
            lastname: values.lastname,
            birthdate: values.birthdate,
            roles: '',
            password: values.password
        }

        if(values.role === "USER"){
            user.roles = userRole
        }else if(values.role === "ADMIN"){
            user.roles = adminRole
        }else user.roles = userRole
        
        UsersDataService.createUser(user)
            .then(() => this.props.navigate('/users')) 
       
    }

    validate(values){
        let errors = {}
        if (!values.username) {
            errors.username = 'Enter your name'
        } else if (values.username.length < 3) {
            errors.username = 'I cant believe you have less than 3 letters in your name....'
        }

        if (!values.lastname) {
            errors.lastname = 'Enter your last name'
        } else if (values.lastname.length < 3) {
            errors.lastname = 'I cant believe you have less than 3 letters in your last name....'
        }

        if (!moment(values.birthdate).isValid()) {
            errors.birthdate = 'Enter a valid Birth Date'
        }

        if (!values.password) {
            errors.password = 'Enter password......'
        } else if (values.password.length < 3) {
            errors.password = 'ARE YOU STUPID ????'
        }

        

        return errors
    }

    render(){
        let { username, lastname, birthdate, role, password } = this.state
        return (
            <div>
                <h1>Create User</h1>
                <div className="container">
                    <Formik  
                        initialValues={{username, lastname, birthdate, role, password}}
                        onSubmit={this.onSubmit}
                        validateOnChange={false}
                        validateOnBlur={false}
                        validate = {this.validate}
                        enableReinitialize={true}
                    >
                        {
                            (props) => (
                                <Form>
                                    <ErrorMessage name="username" component="div"
                                        className="alert alert-warning" />
                                    <fieldset style={{margin : "10px"}} className="form-group">
                                        <label>Username</label>
                                        <Field className="form-control" type="text" name="username" />
                                    </fieldset>

                                    <ErrorMessage name="lastname" component="div"
                                        className="alert alert-warning" />
                                    <fieldset style={{margin : "10px"}} className="form-group">
                                        <label>Lastname</label>
                                        <Field className="form-control" type="text" name="lastname" />
                                    </fieldset>

                                    <ErrorMessage name="birthdate" component="div"
                                        className="alert alert-warning" />
                                    <fieldset style={{margin : "10px"}} className="form-group">
                                        <label>Birthday</label>
                                        <Field className="form-control" type="date" name="birthdate"/>
                                    </fieldset>

                                    <fieldset style={{margin : "10px"}} className="form-group">
                                        <label>Role</label>
                                        <Field className="form-control" type="text" name="role" />
                                    </fieldset>

                                    <ErrorMessage name="password" component="div"
                                        className="alert alert-warning" />
                                    <fieldset style={{margin : "10px"}} className="form-group">
                                        <label>Password</label>
                                        <Field className="form-control" type="text" name="password" />
                                    </fieldset>

                                    <button type="submit" className="btn btn-success" style={{margin : "10px"}}>Save</button>
                                </Form>
                            )
                        }
                    </Formik>
                </div>
            </div>
        )
    }


}

export default CreateUserComponent