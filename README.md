# Music Circle

A social music platform connecting creators and listeners - An Android-based social media application that bridges the gap between music creators and listeners, enabling song sharing, community building, and live event discovery.

## Overview

The Music Circle project consists of two main components:
1. Android Frontend Application 
2. Spring Boot Backend Service

## Project Components

### Backend Architecture

#### Stack
- Java
- Spring Boot
- MySQL
- WebSocket
- Swagger/SpringFox
- JUnit & Mockito for testing

#### Features
- REST API services for User management, Event management, Group creation and management and Playlist handling
- Music file storage and streaming
- Real-time social features using WebSocket

#### Database
- Uses MySQL for production
- H2 for testing/development

## Database Schema

<img width="802" alt="Screenshot 2024-12-18 at 5 18 05 PM" src="https://github.com/user-attachments/assets/fe9fdb7f-4001-4baa-a9bd-3d098066bdc5" />


#### music_user
| Field       | Type          |
|-------------|---------------|
| id (PK)     | BIGINT        |
| username    | VARCHAR(255)  |
| password    | VARCHAR(255)  |
| email       | VARCHAR(255)  |
| first_name  | VARCHAR(255)  |
| last_name   | VARCHAR(255)  |
| created     | DATETIME      |
| logged_in   | BIT(1)        |
| bio         | VARCHAR(255)  |
| profile_pic | VARCHAR(255)  |

#### audio_file
| Field           | Type          |
|-----------------|---------------|
| id (PK)         | BIGINT        |
| contents        | LONGBLOB      |
| filename        | VARCHAR(255)  |
| audio_file_path | BIGINT (FK)   |

#### album
| Field       | Type          |
|-------------|---------------|
| id (PK)     | BIGINT        |
| album_name  | VARCHAR(255)  |
| single      | BIT(1)        |
| user_id     | BIGINT (FK)   |
| artist_id   | BIGINT (FK)   |

#### playlist
| Field       | Type          |
|-------------|---------------|
| id (PK)     | BIGINT        |
| name        | VARCHAR(255)  |
| user_id     | BIGINT (FK)   |
| creator_id  | BIGINT (FK)   |

### Event Management

#### event
| Field       | Type          |
|-------------|---------------|
| id (PK)     | BIGINT        |
| date_time   | DATETIME      |
| description | VARCHAR(255)  |
| location    | VARCHAR(255)  |
| name        | VARCHAR(255)  |
| user_id     | BIGINT (FK)   |

#### event_users_attending
| Field              | Type        |
|-------------------|-------------|
| event_id          | BIGINT (FK) |
| users_attending_id| BIGINT (FK) |

#### event_users_performing
| Field               | Type        |
|--------------------|-------------|
| event_id           | BIGINT (FK) |
| users_performing_id| BIGINT (FK) |

### Music Organization

#### genre
| Field     | Type         |
|-----------|--------------|
| id (PK)   | BIGINT       |
| name      | VARCHAR(255) |

#### audio_file_info
| Field         | Type         |
|--------------|--------------|
| id (PK)      | BIGINT       |
| song_name    | VARCHAR(55)  |
| album_id     | BIGINT (FK)  |
| artist_id    | BIGINT (FK)  |
| audio_file_id| BIGINT (FK)  |
| genre_id     | BIGINT (FK)  |
| user_id      | BIGINT (FK)  |

#### genre_audio_file_infos
| Field              | Type        |
|-------------------|-------------|
| genre_id          | BIGINT (FK) |
| audio_file_infos_id| BIGINT (FK)|

### Playlist Management

#### playlist_audio_files_list
| Field             | Type        |
|------------------|-------------|
| playlist_id      | BIGINT (FK) |
| audio_files_list | BIGINT (FK) |

#### playlist_listeners
| Field        | Type        |
|-------------|-------------|
| playlist_id | BIGINT (FK) |
| listeners_id| BIGINT (FK) |

#### playlist_songs
| Field       | Type        |
|------------|-------------|
| playlist_id| BIGINT (FK) |
| songs_id   | BIGINT (FK) |

### User Content Management

#### music_user_uploaded_songs
| Field            | Type        |
|-----------------|-------------|
| user_id         | BIGINT (FK) |
| uploaded_songs_id| BIGINT (FK)|

#### music_user_uploaded_albums
| Field             | Type        |
|------------------|-------------|
| user_id          | BIGINT (FK) |
| uploaded_albums_id| BIGINT (FK)|

#### music_user_created_playlists
| Field               | Type        |
|--------------------|-------------|
| user_id            | BIGINT (FK) |
| created_playlists_id| BIGINT (FK)|

### Group Management

#### music_group
| Field       | Type         |
|------------|--------------|
| id (PK)    | BIGINT       |
| description| VARCHAR(255) |
| name       | VARCHAR(255) |
| creator_id | BIGINT (FK)  |
| user_id    | BIGINT (FK)  |

#### music_user_created_groups
| Field             | Type        |
|------------------|-------------|
| user_id          | BIGINT (FK) |
| created_groups_id| BIGINT (FK) |

#### music_group_members
| Field      | Type        |
|-----------|-------------|
| group_id  | BIGINT (FK) |
| members_id| BIGINT (FK) |

### Comment Management

#### comment
| Field        | Type         |
|-------------|--------------|
| id (PK)     | BIGINT       |
| text        | VARCHAR(255) |
| audio_file_id| BIGINT (FK) |
| commenter_id| BIGINT (FK)  |

### Additional Tables

#### album_audio_files_list
| Field            | Type        |
|-----------------|-------------|
| album_id        | BIGINT (FK) |
| audio_files_list| BIGINT (FK) |

#### album_songs
| Field    | Type        |
|---------|-------------|
| album_id| BIGINT (FK) |
| songs_id| BIGINT (FK) |

#### hibernate_sequence
| Field    | Type   |
|---------|--------|
| next_val| BIGINT |


