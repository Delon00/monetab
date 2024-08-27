
function showSection(event, section) {
    if (event) {
        event.preventDefault();
    }

    let sidebarLinks = document.querySelectorAll('.sidebar-link');
    sidebarLinks.forEach(function(link) {
        link.classList.remove('current');
    });

    if (event && event.target) {
        event.target.classList.add('current');
    } else {
        const defaultLink = document.querySelector(`a[href="#${section}"]`);
        if (defaultLink) {
            defaultLink.classList.add('current');
        }
    }

    loadSection(section);
}

function loadSection(section) {
    let sectionUrl = '';
    console.log(section)
    switch (section) {
        case 'page-dash':
            sectionUrl = 'dashboard';
            break;
        case 'page-eleve':
            sectionUrl = 'students';
            break;
        case 'page-professeur':
            sectionUrl = 'teachers';
            break;
        case 'form-professeur':
             sectionUrl = 'teachers/formTeacher';
             break;
        case 'form-eleve':
              sectionUrl = 'students/formStudent';
               break;
        case 'form-user':
               sectionUrl = 'users/formUser';
               break;
        case 'page-utilisateur':
            sectionUrl = 'users';
            break;
        case 'page-rapport':
            sectionUrl = 'rapports';
            break;
        default:
            sectionUrl = '';
    }

    if (sectionUrl !== '') {
        fetch(sectionUrl)
            .then(response => response.text())
            .then(html => {
                document.getElementById('main-content').innerHTML = html;
            })
            .catch(error => console.log('Error loading section:', error));
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
