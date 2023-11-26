import React, {useEffect, useState} from 'react';
import { useNavigate } from "react-router-dom";

export default function Fstvl(props) {

    const navigate = useNavigate();

    const [fstvl, setFstvl] = useState(null);

    const onClickFstvlItem = () => {
        navigate(`/main/detail/${props.title}`, {
            state : props
        })
        fetch(`http://localhost:8080/main/${props.fstvl_id}`,{
            method: "POST",
            body: JSON.stringify(props.fstvl_id)
        })
            .then((response) => response.json())
            .then((data) => setFstvl(data));
    }

    return(
        <div className='Fstvl-container' onClick={onClickFstvlItem}>
            <img src={props.photo} alt="축제사진"/>
            <div className='Fstvl-info'>
                <div>{props.title}</div>
            </div>
        </div>
    )
}