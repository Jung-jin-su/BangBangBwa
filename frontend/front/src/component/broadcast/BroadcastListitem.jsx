import React from "react";
// import Card from 'react-bootstrap/Card';
import styled from "styled-components";

const SCardDiv = styled.div`
  display: flex;
  flex-direction: column;
  width: 250px;
  height: 400px;
  margin-right: 50px;
  margin-bottom: 0px;
  border: 1px solid grey;
  border-radius: 8px;
  cursor: pointer;
  background: white;
  :hover {
    background: lightgrey;
  }
  text-align: center;
`;

const SCardImg = styled.img`
  width: 250px;
  height: 250px;
`;

const SCardBodyDiv = styled.div`
  // width: 100%;
`;

const SCardTitleP = styled.p`
  margin-top: 10px;
  font-size: 30px;
`;

const SCardContentP = styled.p`
  font-size: 20px;
`;

function BroadcastListItem(props) {
    const { post, onClick } = props;
    return (
      <SCardDiv onDoubleClick={onClick}>
        <SCardImg variant="top" src="logo512.png" alt="이미지" />
        <SCardBodyDiv>
          <SCardTitleP>{post.title}</SCardTitleP>
          <SCardContentP>
            {post.type},
            {post.building_type},
            {post.manage_fee}
          </SCardContentP>
        </SCardBodyDiv>
      </SCardDiv>
    )
}

export default BroadcastListItem;