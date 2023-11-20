import React from 'react';
import { useNavigate } from "react-router-dom";
import axios from 'axios';

export default function Fstvl(props) {

    const navigate = useNavigate();

    const onClickFstvlItem = () => {
        navigate(`/main/detail/${props.title}`, {
            state : props
        })
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