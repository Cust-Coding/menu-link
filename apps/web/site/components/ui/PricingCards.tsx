import { CircleCheckBig } from "lucide-react";
type Plan = {
  name: string;
  price: string;
  features: string[];
  limits: string[];
  recommended?: boolean;
};

const plans: Plan[] = [
  {
    name: "BASIC",
    price: "0 MZN / mês",
    features: [
      "Menu digital",
      "Dashboard interativo",
      "Histórico de pedidos",
      "Caixa de reclamação do Customer",
    ],
    limits: ["Até 50 produtos ativos", "1GB de dados do restaurante"],
  },
  {
    name: "PRO",
    price: "250 MZN / mês",
    features: [
      "Tudo do BASIC",
      "Gestão de stock",
      "Fidelização de clientes",
      "Website demo do restaurante",
      "Modelo de pesquisa operacional",
    ],
    limits: ["Até 150 produtos ativos", "2.5GB de dados do restaurante"],
    recommended: true,
  },
  {
    name: "PREMIUM",
    price: "500 MZN / mês",
    features: [
      "Tudo do PRO",
      "AI para recomendação e upsell",
      "Analytics avançado",
      
    ],
    limits: ["Até 300 produtos ativos", "4GB de dados do restaurante"],
  },
];

export default function PricingCards() {
  return (
    <div className="flex flex-col lg:flex-row gap-8 justify-center items-stretch px-6 py-12 ">
      {plans.map((plan) => (
        <div
          key={plan.name}
          className={`relative w-full max-w-sm rounded-4xl bg-white p-6 shadow-lg flex flex-col
            ${
              plan.recommended
                ? "border-2 border-green-600 scale-105"
                : "border border-gray-200"
            }`}
        >
          {plan.recommended && (
            <span className="absolute -top-3 left-1/2 -translate-x-1/2 bg-green-600 text-white text-xs font-bold px-4 py-1 rounded-full">
              Recomendamos
            </span>
          )}

          <h3 className="text-xl text-green-600 font-bold text-start text-black">{plan.name}</h3>

            <p className="text-start text-black my-4">
                <span className="text-3xl font-bold">{plan.price.split(" ")[0]}</span>{" "}
                <span className="text-2xl font-semibold opacity-80">{plan.price.split(" ").slice(1).join(" ")}</span>
            </p>

          <ul className="flex-1 space-y-3 text-sm text-gray-700">
            {plan.features.map((feature) => (
              <li key={feature} className="flex items-start gap-2">
                <span className="text-green-600 font-bold"><CircleCheckBig /></span>
                {feature}
              </li>
            ))}
          </ul>

          <div className="mt-4 text-xs text-gray-500">
            {plan.limits.map((limit) => (
              <p key={limit}>{limit}</p>
            ))}
          </div>

          <button
            className={`mt-6 w-full rounded-full py-3 font-semibold transition cursor-pointer
              ${
                plan.recommended
                  ? "bg-green-600 text-white hover:bg-green-600"
                  : "bg-green-600/50 hover:bg-green-600"
              }`}
          >
            Escolher plano
          </button>
        </div>
      ))}
    </div>
  );
}
