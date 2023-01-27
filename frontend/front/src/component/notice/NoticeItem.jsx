import React from "react";
import styled from "styled-components";
import { useNavigate } from "react-router-dom";

const StyledTd = styled.td`
  cursor: pointer;
  :hover {
    text-decoration: underline;
 }
`

function NoticeItem(props) {
    const data = props.post
    const navigate = useNavigate();
    const onClick = () => {
        navigate(`/notices/${data.id}`)
    }

    return (
      <tr>
        <td><center>{data.id}</center></td>
        <StyledTd onClick={onClick}>[{data.type}] {data.title}</StyledTd>
        <td><center>{data.regidate}</center></td>
      </tr>
    )
  }
  
  export default NoticeItem;