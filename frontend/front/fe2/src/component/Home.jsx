import React from "react";
import ItemList from "./list/ItemList"
import data from "../data.json";
import { useNavigate } from "react-router-dom";

function Home() {
  const navigate = useNavigate();

  return (
    <div>
      <div>
        <h2>지금 핫한 방송</h2>
        <hr />
        <ItemList
          posts={data}
          onClickItem={(item) => {
              navigate(`/items/${item.id}`);
          }}
        />
      </div>
      <hr/>
      <h2>인기 급상승 매물</h2>
      <div>

      </div>
    </div>
  )
}

export default Home;