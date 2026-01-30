'use client'; 

import { useTranslation } from "react-i18next";
import type {TranslationKeys} from "../i18n/i18n"

export default function Nav() {
  const { t } = useTranslation();


  const menuKeys: Array<keyof TranslationKeys> = [
    "features",
    "pricing",
    "about",
    "support",
    "contact",
  ];

  return (
    <nav className="flex items-center justify-center gap-4 py-1.5 px-3 bg-foreground/6 rounded-md ">
      {menuKeys.map((key) => (
        <a
          key={String(key)}
          href={`#${key}`}
          className="text-dynamic text-foreground hover:text-green-600 hover:font-semibold transition-colors duration-300"
        >
          {t(key)}
        </a>
      ))}
    </nav>
    
    </>
    
  );
}
