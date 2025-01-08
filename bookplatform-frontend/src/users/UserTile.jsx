import "./UserTile.css"

function UserTile(props) {

    const { id, userLogin, userAvatar, booksRead, reviewsCreated } = props;

    return (
        <div className="userTileDiv">
            <img className="userTileImg" src={`data:image/jpeg;base64,${userAvatar}`}/>
            <div className="userDescriptionDiv">
                <h2><a href={"/users/" + id}>{userLogin}</a></h2>
                <p>Книг прочитано: {booksRead}</p>
                <p>Рецензий написано: {reviewsCreated}</p>
            </div>
        </div>
    )
}

export default UserTile;