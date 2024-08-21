function showSection(event, section) {
    if (event) {
        event.preventDefault();
    }

    let sidebarLinks = document.querySelectorAll('.sidebar-link');
    sidebarLinks.forEach(function(link) {
        link.classList.remove('current');
    });

    if (event) {
        event.target.classList.add('current');
    } else {
        const defaultLink = document.querySelector(`a[href="#${section}"]`);
        if (defaultLink) {
            defaultLink.classList.add('current');
        }
    }

    let sectionUrl = '';

    switch(section) {
        case 'page-dash':
            sectionUrl = 'dashboard/composant/dashboard :: dashboard-content';
            break;
        case 'page-eleve':
            sectionUrl = 'dashboard/composant/eleves :: eleves-content';
            break;
        case 'page-professeur':
            sectionUrl = 'dashboard/composant/professeurs :: professeurs-content';
            break;
        case 'page-utilisateur':
            sectionUrl = 'dashboard/composant/utilisateurs :: utilisateurs-content';
            break;
        case 'page-rapport':
            sectionUrl = 'dashboard/composant/rapports :: rapports-content';
            break;
        default:
            sectionUrl = '';
    }

    if (sectionUrl) {
        fetch(sectionUrl)
            .then(response => response.text())
            .then(html => {
                document.getElementById('main-content').innerHTML = html;
            });
    }
}

document.addEventListener('DOMContentLoaded', function() {
    showSection(null, 'page-dash');
});





function openmodal() {
    var menuEleve = document.querySelector('.menu-eleve');
    menuEleve.style.display = 'block';
}
function closemodal() {
    var menuEleve = document.querySelector('.menu-eleve');
    menuEleve.style.display = 'none';
}

function openmodify() {
    var menuEleve = document.querySelector('.menu-eleve-modify');
    menuEleve.style.display = 'block';
}
function closemodify() {
    var menuEleve = document.querySelector('.menu-eleve-modify');
    menuEleve.style.display = 'none';
}

function opendelete() {
    var menuEleve = document.querySelector('.delete-modal');
    menuEleve.style.display = 'flex';
}
function closedelete() {
    var menuEleve = document.querySelector('.delete-modal');
    menuEleve.style.display = 'none';
}