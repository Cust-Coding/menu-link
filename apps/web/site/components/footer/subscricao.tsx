'use client'
import { useState, FormEvent } from "react";

export default function Subscricao() {
  const [email, setEmail] = useState("");
  const [sucesso, setSucesso] = useState(false);

  function handleSubmit(e: FormEvent) {
    e.preventDefault();

    // 
    

    setSucesso(true);
    setEmail("");
  }

  return (
    <form onSubmit={handleSubmit} className="flex items-center justify-center gap-1 md:gap-3">
      <input
        id="email"
        type="email"
        placeholder="seu@email.com"
        className="bg-white rounded-full text-black p-1 md:p-2 font-semibold"
        value={email}
        onChange={(e) => setEmail(e.target.value)}
        required
      />

      <button type="submit" className="bg-white rounded-xl hover:rounded-bl-3xl hover:rounded-br-none hover:rounded-tr-3xl hover:rounded-tl-none cursor-pointer text-black p-1 md:p-2 duration-200 transition-all hover:font-semibold">Subscrever</button>

      {sucesso && <p>Subscrição feita com sucesso!</p>}
    </form>
  );
}
