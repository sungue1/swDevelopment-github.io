import React from 'react';
import {Background, LoadingText} from './Styles';

function Loading() {
    return (
        <Background>
            <LoadingText>잠시만 기다려 주세요.</LoadingText>
            <img src={process.env.PUBLIC_URL + '/Loading.gif'} alt="로딩중" width="5%" />
        </Background>
    );
};

export default Loading;