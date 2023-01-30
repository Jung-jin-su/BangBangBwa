import React from "react";
import { Routes, Route } from "react-router-dom";
import BroadcastAll from "../component/broadcast/BroadcastAll";
import BroadcastLive from "../component/broadcast/BroadcastLive";
import BroadcastWrite from "../component/broadcast/BroadcastWrite";
import LiveBroadcastList from "../component/broadcast/LiveBroadcastList";
import NonLiveBroadcastList from "../component/broadcast/NonLiveBroadcastList";


function Broadcasts() {
  return (
    <div>
      <h1>Broadcast</h1>
      <hr/>
      <Routes>
        <Route index element={<BroadcastAll />} />
        <Route path=":postId" element={<BroadcastLive />} />
        <Route path="new" element={<BroadcastWrite />} />
        <Route path="live" element={<LiveBroadcastList />} />
        <Route path="nonlive" element={<NonLiveBroadcastList />} />
      </Routes>
    </div>
  )
}

export default Broadcasts;