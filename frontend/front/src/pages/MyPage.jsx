import React, { useState, useEffect } from "react";
import {
  Routes,
  Route
} from "react-router-dom";
import styled from "styled-components";
import NewBroker from "../component/mypage/NewBroker";
import MyItem from '../component/mypage/MyItem';
import MyBroadcast from "../component/mypage/MyBroadcast";
import MyPageSide from "../component/mypage/MyPageSide";
import MyProfile from "../component/mypage/MyProfile";

import { useDispatch, useSelector } from 'react-redux';

import { searchMyItemAsync } from "../reducers/itemSlice"
import { searchMyBroadcastAsync } from "../reducers/broadcastSlice"


const Wrapper = styled.div`
  margin-top: 3rem;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  text-align: center;
`;

const SecondWrapper = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
`;

const Container = styled.div`
  display: flex;    
  width: 100%;
  max-width: 70%;
`;

function MyPage() {
  const { myPageStatus } = useSelector((state) => state.commonSlice);
  const { me } = useSelector((state) => state.userSlice);
  const dispatch = useDispatch();
  useEffect(() => {
    if (me.role === 'ROLE_ADMIN' || me.role === "ROLE_BROKER") {
      dispatch(searchMyItemAsync())
      dispatch(searchMyBroadcastAsync())
    }
  },[])

  console.log(me)

  return (
    <Wrapper>
      <SecondWrapper>
        <Container>
          <MyPageSide />
          {myPageStatus === 1 && <MyProfile />}
          {myPageStatus === 2 && <NewBroker />}
          {myPageStatus === 3 && <MyItem />}
          {myPageStatus === 4 && <MyBroadcast />}
        </Container>
      </SecondWrapper>
    </Wrapper>
  )
}

export default MyPage;