import {useState} from "react";
import '../css/Keyword.css';

function Keyword(props) {
    const [isHovering, setIsHovering] = useState(false);
    const [isClick, setIsClick] = useState(false);

    const handleMouseOver = () => {setIsHovering(true)}
    const handleMouseOut = () => {setIsHovering(false)}

    const onClickItem = () => {
        if (isClick === false) {
            setIsClick(true);
            props.getKeyword(props.name);
        }
        else {
            setIsClick(false);
            props.delKeyword(props.name);
        }
    };

    return(
        <button
            className = {isClick ? 'keyClick' : isHovering ? 'keyHover' : 'key_button'}
            onClick = {onClickItem}
            onMouseOver = {handleMouseOver}
            onMouseOut={handleMouseOut}
        >
            {props.name}
        </button>
    )
}

export default Keyword;