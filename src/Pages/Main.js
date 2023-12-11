import React, { useState, useEffect} from 'react';
import axios from 'axios';
import Fstvl from '../Component/Fstvl';
import Loading from '../Component/Loading';
import Modal from 'react-modal';
import Key_Modal from "./Key_Modal";
import Location_Modal from "./Location_Modal";
import Calendar_Modal from "./Calendar_Modal";
import '../css/Main.css';

function Main() {
    const [loading, setLoading] = useState(false);
    const [fstvls, setFstvl] = useState(null);
    const [isKeySearchModalOpen, setIsKeySearchModalOpen] = useState(false);
    const [isLocationModalOpen, setIsLocationModalOpen] = useState(false);
    const [isCalendarModalOpen, setIsCalendarModalOpen] = useState(false);
    const [calendarDate, setCalendarDate] = useState('여기를 눌러서 날짜를 선택하세요');
    const [keyWordList, setKeyWordList] = useState(['여기를 눌러서 키워드를 선택하세요']);
    const [text, setText] = useState('이 달의 축제');
    const openKeySearchModal = () => {setIsKeySearchModalOpen(true)}
    const closeKeySearchModal = () => {setIsKeySearchModalOpen(false)}
    const openCalendarModal = () => {setIsCalendarModalOpen(true)}
    const closeCalendarModal = () => {setIsCalendarModalOpen(false)}
    const openLocationModal = () => {
        setIsLocationModalOpen(true);
        setLoading(false);
    }
    const closeLocationModal = () => {
        setIsLocationModalOpen(false);
        if (!fstvls) {
            setLoading(true);
        }
    }
    const getCalendarDate = date => {setCalendarDate(date)}
    const getKeywords = word => {setKeyWordList(word)}
    let keyWord;

    Modal.setAppElement('#root')

    const viewKey = () => {
        if (keyWordList === ['여기를 눌러서 키워드를 선택하세요']) {
            return '여기를 눌러서 키워드를 선택하세요'
        }
        else {
            return keyWordList.join();
        }
    }

    const onClickSearchItem = async () => {
        try {
            setLoading(true);
            keyWord = keyWordList.join();
            const response = await axios.post(`http://localhost:8080/main/${keyWord}/${calendarDate}`);
            setFstvl(response.data);
            console.log(fstvls.title);
        } catch (error){
            console.log(error);
        } finally {
            setText("필터링 결과");
            setLoading(false);
        }
    }

    const fetchData = async () => {
        try {
            const response_fstvl = await axios.get('http://localhost:8080/main');
            setFstvl(response_fstvl.data);
        } catch (error) {
            console.error('Error fetching data:', error);
        } finally {
            setLoading(false);
        }
    }

    useEffect( () => {
        fetchData();
    },[]);

    // App element 설정
    useEffect(() => {
        const timeoutId = setTimeout(() => {
            openLocationModal();
        }, 300);
        // 컴포넌트가 unmount 될 때 clearTimeout을 통해 타이머 해제
        return () => clearTimeout(timeoutId);
    }, []);

    return (

        <div>
            {loading ? <Loading /> : null}
            <div className="main-container">
                {fstvls && fstvls.map((fstvl) => (
                    <Fstvl
                        key={fstvl.fstvl_id}
                        title={fstvl.title}
                        photo={fstvl.photo}
                        date={fstvl.date}
                        location={fstvl.location}
                        price={fstvl.price}
                        phone={fstvl.phone}
                        text={fstvl.text}
                        fstvl_keyword={fstvl.fstvl_keyword}
                        fstvl_id={fstvl.fstvl_id}
                    />
                ))}
            </div>
            <div>
                {/* 위치 모달 */}
                <div className="open_location_modal" onClick={openLocationModal}></div>
                <Modal
                    className = 'location_modal_size'
                    isOpen={isLocationModalOpen}
                    onRequestClose={closeLocationModal}
                    contentLabel="Location Modal"
                >
                    <Location_Modal closeModal={closeLocationModal}/>
                </Modal>
                <div className="key_date"/>
                <div className="date_icon">
                    <img src = {process.env.PUBLIC_URL + '/Calendar.png'} width = '55px' height = '55px'/>
                </div>
                <div className="date_search" onClick={openCalendarModal}>{calendarDate}</div>
                {/* 달력 모달 */}
                <Modal className = 'calendar_modal_size'
                    isOpen={isCalendarModalOpen}
                    onRequestClose={closeCalendarModal}
                    contentLabel="Calendar Modal"
                >
                    <Calendar_Modal closeModal={closeCalendarModal} getCalendarDate={getCalendarDate}/>
                </Modal>
                <div className="key_icon">#</div>
                <div className="key_search" onClick={openKeySearchModal}>{viewKey()}</div>
                {/* 키워드 모달 */}
                <Modal
                    className='key_modal_size'
                    isOpen={isKeySearchModalOpen}
                    onRequestClose={closeKeySearchModal}
                    contentLabel="Key Search Modal"
                >
                    <Key_Modal closeModal={closeKeySearchModal} getKeywords={getKeywords}/>
                </Modal>
                <div className="search" onClick={onClickSearchItem}>검색</div>
                <div className="text_thisMonth">{text}</div>
            </div>
        </div>
    );
}
export default Main;