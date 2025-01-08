import "./AuthorTile.css"

function AuthorTile(props) {

    const { id, authorPhoto, firstName, lastName, patronymic, dateOfBirth, dateOfDeath } = props;

    return (
        <div className="authorTileDiv">
            <img className="authorTileImg" src={`data:image/jpeg;base64,${authorPhoto}`}/>
            <div className="authorDescriptionDiv">
                <h2><a href={"/authors/" + id}>{`${firstName[0]}. ${patronymic[0]}. ${lastName}`}</a></h2>
                <p>{`${dateOfBirth} - ${dateOfDeath}`}</p>
            </div>
        </div>
    )
}

export default AuthorTile;