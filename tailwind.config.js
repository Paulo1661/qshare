/** @type {import('tailwindcss').Config} */
module.exports = {
    content: ['./src/main/resources/templates/**/*.html'],
    theme: {
        extend: {},
    },
    daisyui: {
        themes: ["light", "dark", "cupcake"],
    },
    plugins: [
        require('daisyui'),
        // require('@tailwindcss/forms'),
        require('@tailwindcss/typography'),
        // require('tailwind-scrollbar'),
    ],

}

