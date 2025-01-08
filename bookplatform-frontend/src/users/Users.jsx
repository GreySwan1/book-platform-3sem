import Navigation from "../navigation/Navigation.jsx";
import {useEffect, useState} from "react";
import {getUsers} from "../api/apiCall.js";
import "./Users.css"
import UserTile from "./UserTile.jsx";


function Users() {

    const [users, setUsers] = useState();

    useEffect(() => {
        getUsers().then(res => setUsers(res))
    }, []);

    return (
        users && <>
            <Navigation/>
            <div className="usersContainer">
                <h1>Пользователи</h1>
                <div className="usersListDiv">
                    {
                        users.users.map(
                            (item, key) => {
                                return <UserTile
                                    key={key}
                                    id={item.id}
                                    userLogin={item.login}
                                    userAvatar={item.picture}
                                    booksRead={item.booksRead}
                                    reviewsCreated={item.reviews.length}
                                />
                            }
                        )
                    }
                </div>
            </div>
        </>
    )
}

export default Users;
