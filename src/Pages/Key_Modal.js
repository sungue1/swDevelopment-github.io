import React, {useState} from 'react';
import Keyword from '../Component/Keyword';
import '../css/Key_Modal.css';

function Key_Modal(props) {
    const [keywords, setKeywords] = useState([]);
    const getKeyword = word => {
        if (!keywords.includes(word)) {
            if (word === '선택 안 함') {
                setKeywords(prevKeywords => [...prevKeywords, "없음"]);
            }
            else {
                setKeywords(prevKeywords => [...prevKeywords, word]);
            }
        }
    }
    const delKeyword = delWord => {
        if (delWord === '선택 안 함') {
            setKeywords(prevKeywords => prevKeywords.filter(word => word !== '없음'));
        }
        else {
            setKeywords(prevKeywords => prevKeywords.filter(word => word !== delWord));
        }
    }
    const handleSave = () => {
        props.getKeywords(keywords);
        props.closeModal();
    }

    return (
        <div>
            <div className='key_title'>키워드 선택</div>
            <div>
                <Keyword name = '1인' getKeyword = {getKeyword} delKeyword = {delKeyword}/>
                <Keyword name = '연인' getKeyword = {getKeyword} delKeyword = {delKeyword}/>
                <Keyword name = '가족' getKeyword = {getKeyword} delKeyword = {delKeyword}/>
                <Keyword name = '음식' getKeyword = {getKeyword} delKeyword = {delKeyword}/>
                <Keyword name = '실버' getKeyword = {getKeyword} delKeyword = {delKeyword}/>
                <Keyword name = '춤' getKeyword = {getKeyword} delKeyword = {delKeyword}/>
                <Keyword name = '음악' getKeyword = {getKeyword} delKeyword = {delKeyword}/>
                <Keyword name = '미술' getKeyword = {getKeyword} delKeyword = {delKeyword}/>
                <Keyword name = '아동' getKeyword = {getKeyword} delKeyword = {delKeyword}/>
                <Keyword name = '교육' getKeyword = {getKeyword} delKeyword = {delKeyword}/>
                <Keyword name = '이국적인' getKeyword = {getKeyword} delKeyword = {delKeyword}/>
                <Keyword name = '자연' getKeyword = {getKeyword} delKeyword = {delKeyword}/>
                <Keyword name = '전통' getKeyword = {getKeyword} delKeyword = {delKeyword}/>
                <Keyword name = '지역' getKeyword = {getKeyword} delKeyword = {delKeyword}/>
                <Keyword name = '휴양' getKeyword = {getKeyword} delKeyword = {delKeyword}/>
                <Keyword name = '익스트림' getKeyword = {getKeyword} delKeyword = {delKeyword}/>
                <Keyword name = '체육' getKeyword = {getKeyword} delKeyword = {delKeyword}/>
                <Keyword name = '선택 안 함' getKeyword = {getKeyword} delKeyword = {delKeyword}/>
                <button className = 'key_button_save' onClick={handleSave}>저장</button>
                <button className = 'key_button_close' onClick={props.closeModal}>닫기</button>
            </div>
        </div>
    );
}
export default Key_Modal;
