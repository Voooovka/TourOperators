import { Component } from "react";
import moment from 'moment'
import UsersDataService from "../../../api/UsersDataService";

class ListUsersComponent extends Component{

    constructor(props){
        super(props)
        this.state = {
            users : [],
            message : null
        }

    }

    componentDidMount(){
        this.refreshUsers()
    }

    refreshUsers(){
        UsersDataService.getAllUsers()
        .then(
            response => {
                this.setState({users : response.data})
            }
        )
    }

    deleteUserClicked(id){
        UsersDataService.deleteUser(id)
        .then(
            response => {
                this.setState({message : `Delete of user ${id} Successful`})
                this.refreshUsers()
            }
        )
    }

    addUserClicked = () => {
        this.props.navigate(`/users/create`)
    }

    updateUserClicked(id){
        this.props.navigate(`/users/${id}`)
    
    }


    render(){
        return (
            <div>
                <h1>List of Users</h1>
                {this.state.message && <div className='alert alert-success'>{this.state.message}</div>}
                <div className="container">
                    <table className="table">
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>Username</th>
                                <th>Lastname</th>
                                <th>Birthday</th>
                                <th>Role</th>
                                <th></th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.users.map(
                                    user =>
                                        <tr key={user.id}>
                                            <td>{user.id}</td>
                                            <td>{user.username}</td>
                                            <td>{user.lastname}</td>
                                            <td>{moment(user.birthdate).format('YYYY-MM-DD')}</td>
                                            <td>{user.roles.name}</td>
                                            {/* <td><button className='btn btn-info'>Info</button></td> */}
                                            <td><button className='btn btn-success' onClick={() => this.updateUserClicked(user.id)}>Uptade</button></td>
                                            <td><button className='btn btn-warning'onClick={() => this.deleteUserClicked(user.id)}>Delete</button></td>
                                        </tr>
                                )
                            }  
                        </tbody>
                    </table>
                    <div className="row">
                        <button className="btn btn-success" onClick={this.addUserClicked}>Add</button>
                    </div>
                </div>
            </div>
        )
    }
}

export default ListUsersComponent