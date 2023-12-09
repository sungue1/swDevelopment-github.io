import React, {useEffect, useState} from 'react';
import Calendar from 'react-calendar';
import moment from 'moment';
import '../css/Calendar.css';
import 'react-calendar/dist/Calendar.css'; // css import

function Calendar_Modal(props) {
    const [value] = useState(new Date());
    const [selectedStartDate, setSelectedStartDate] = useState(null);
    const [selectedEndDate, setSelectedEndDate] = useState(null);

    const handleDateClick = (date) => {
        if (!selectedStartDate) {
            // 시작 날짜 선택
            setSelectedStartDate(date);
            setSelectedEndDate(null);
        } else if (!selectedEndDate) {
            // 종료 날짜 선택
            setSelectedEndDate(date);
        } else {
            // 날짜 재선택
            setSelectedStartDate(date);
            setSelectedEndDate(null);
        }
    };

    const tileClassName = ({ date }) => {
        if (selectedStartDate && selectedEndDate) {
            return (
                (date >= selectedStartDate && date <= selectedEndDate) ||
                date.getTime() === selectedStartDate.getTime() ||
                date.getTime() === selectedEndDate.getTime()
            )
                ? 'selected-date'
                : '';
        } else {
            return date.getTime() === selectedStartDate?.getTime() ? 'selected-date' : '';
        }
    };

    const tileContent = ({ date, view }) => {
        if (selectedStartDate && selectedEndDate) {
            return (
                (date > selectedStartDate && date < selectedEndDate) ||
                date.getTime() === selectedStartDate.getTime() ||
                date.getTime() === selectedEndDate.getTime()
            )
                ? <div className="selected-marker"></div>
                : null;
        } else {
            return date.getTime() === selectedStartDate?.getTime()
                ? <div className="selected-marker"></div>
                : null;
        }
    };
    let [date ] = '';

    const selectedDatesInfo = () => {
        if (selectedStartDate && selectedEndDate) {
            const format = 'YYYY.MM.DD';
            const startDate = moment(selectedStartDate).format(format);
            const endDate = moment(selectedEndDate).format(format);
            date = `${startDate}~${endDate}`;
            props.closeModal();
        } else if (selectedStartDate) {
            const format = 'YYYY.MM.DD';
            return moment(selectedStartDate).format(format);
        } else {
            return '날짜를 선택하세요.';
        }
    };

    useEffect(() => {
        props.getCalendarDate(date);
        console.log(date);
    }, [selectedDatesInfo]);

    return (
        <div className = "custom-calendar-container">
            <Calendar
                onChange={handleDateClick}
                value={value}
                tileClassName={tileClassName}
                tileContent={tileContent}
            />
            <div className="selected-dates-info">{selectedDatesInfo()}</div>
            <button onClick={props.closeModal}>닫기</button>
        </div>
    );
}

export default Calendar_Modal;
