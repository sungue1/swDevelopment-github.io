import React, { useState } from 'react';
import axios from "axios";
import '../css/Location_Modal.css';

const Location_Modal = ({closeModal}) => {
    const [locationInput, setLocationInput] = useState('');
    const handleLocationInputChange = (event) => {setLocationInput(event.target.value)};
    const submitLocation = async () => {
        console.log('Location submitted:', locationInput);
        await axios.put(`http://localhost:8080/main/${locationInput}`, {
            user_location: locationInput,
        }, {
            headers: {
                'Content-Type': 'application/json'
            }
        });
        closeModal();
    };

    return (
        <div>
            <h2>위치 입력</h2>
            <p>열차편 출발역을 위한 사용자의 현재 위치를 입력하세요</p>
            <p>ex) "경상남도 진주시"</p>
            {/* 위치 입력을 받는 input 요소 */}
            <input
                type="text"
                value={locationInput}
                onChange={handleLocationInputChange}
                placeholder="원하는 위치를 입력하세요"
            />

            {/* 위치 정보를 서버에 보내는 버튼 */}
            <button className = 'complete_location' onClick={submitLocation}>위치 선택 완료</button>
        </div>
    );
};

export default Location_Modal;