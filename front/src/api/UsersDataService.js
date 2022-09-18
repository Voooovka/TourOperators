import axios from 'axios'

class UsersDataService{

    getAllUsers(){
        return axios.get(`http://localhost:8080/users`)
    }

    deleteUser(id){
        return axios.delete(`http://localhost:8080/users/${id}`)
    }

    createUser(todo) {
        return axios.post(`http://localhost:8080/users`, todo);
    }

    getTodo(id){
        return axios.get(`http://localhost:8080/users/${id}`)
    }

    updateTodo(id, todo) {
        return axios.put(`http://localhost:8080/users/${id}`, todo);
    }
}

export default new UsersDataService()