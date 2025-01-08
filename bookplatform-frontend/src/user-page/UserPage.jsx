import Navigation from "../navigation/Navigation.jsx";
import {useEffect, useState} from "react";
import "./UserPage.css"
import {getUser} from "../api/apiCall.js";


function UserPage() {

    const [user, setUser] = useState();

    useEffect(() => {
        const splitResult = window.location.href.split("/");
        const id = splitResult[splitResult.length - 1];
        getUser(id).then(res => setUser(res))
    }, []);

    return (
        user && <>
            <Navigation/>
            <div className="userContainerDiv">
                <div className="userCoverDiv">
                    <img className="userPictureImg" src={`data:image/jpeg;base64,${user.picture}`}/>
                </div>
            </div>
            <div className="userInfoDiv">
                <h1>{user.login}</h1>
                <p>Дата регистрации: {user.registrationDate}</p>
                <p>Книг прочитано: {user.booksRead}</p>
                <p>Рецензий написано: {user.reviews.length}</p>
                <p>Сейчас читает: {user.nowReading}</p>
            </div>
            <h2 className="reviewsH2">Рецензии пользователя</h2>
            <div className="reviewContainerDiv">
                {
                    user.reviews.map((item, key) => {
                            return <div key={item.id} className="reviewDiv">
                                        <div className="reviewAuthorDiv">
                                            <img className="reviewAvatarImg" src={`data:image/jpeg;base64,${item.picture}`}/>
                                            <p className="reviewerUsername">{item.title}</p>
                                        </div>
                                        <p className="reviewTextP">{item.text}</p>
                                    </div>
                        }
                    )
                }
            </div>
        </>
    )
}

export default UserPage;
