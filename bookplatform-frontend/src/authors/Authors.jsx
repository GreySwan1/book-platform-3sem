import Navigation from "../navigation/Navigation.jsx";
import {useEffect, useState} from "react";
import {getAuthors} from "../api/apiCall.js";
import "./Authors.css"
import AuthorTile from "./AuthorTile.jsx";


function Authors() {

    const [authors, setAuthors] = useState();

    useEffect(() => {
        getAuthors().then(res => setAuthors(res))
    }, []);

    return (
        authors && <>
            <Navigation/>
            <div className="authorsContainer">
                <h1>Авторы</h1>
                <div className="authorsListDiv">
                    {
                        authors.authors.map(
                            (item, key) => {
                                return <AuthorTile
                                    key={key}
                                    id={item.id}
                                    authorPhoto={item.picture}
                                    firstName={item.firstName}
                                    lastName={item.lastName}
                                    patronymic={item.patronymic}
                                    dateOfBirth={item.dateOfBirth}
                                    dateOfDeath={item.dateOfDeath}
                                />
                            }
                        )
                    }
                </div>
            </div>
        </>
    )
}

export default Authors;
